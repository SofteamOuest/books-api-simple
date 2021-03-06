import java.text.SimpleDateFormat

// pod utilisé pour la compilation du projet
podTemplate(label: 'api-book-build-pod', nodeSelector: 'medium', containers: [

        // le slave jenkins
        containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:alpine'),
        // un conteneur pour le build maven
        containerTemplate(name: 'maven', image: 'maven:3.5.0', ttyEnabled: true, command: 'cat'),
        // un conteneur pour construire les images docker
        containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true),
        // un conteneur pour déployer les services kubernetes
        containerTemplate(name: 'kubectl', image: 'lachlanevenson/k8s-kubectl', command: 'cat', ttyEnabled: true)],

        // montage nécessaire pour que le conteneur docker fonction (Docker In Docker)
        volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]
) {

    node('api-book-build-pod') {

        def now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())

        stage('checkout sources'){
                    checkout scm;
        }

        container('maven') {

            sh 'mvn clean package sonar:sonar -Dsonar.host.url=http://sonarqube.k8.wildwidewest.xyz -Dsonar.java.binaries=target'
        }

       container('docker') {
            
            stage('build docker image'){


                sh "docker build -t registry.k8.wildwidewest.xyz/repository/docker-repository/pocs/books-api-simple:$now ."

                sh 'mkdir /etc/docker'

                // le registry est insecure (pas de https)
                sh 'echo {"insecure-registries" : ["registry.k8.wildwidewest.xyz"]} > /etc/docker/daemon.json'

                withCredentials([string(credentialsId: 'nexus_password', variable: 'NEXUS_PWD')]) {

                    sh "docker login -u admin -p ${NEXUS_PWD} registry.k8.wildwidewest.xyz"
                }

                sh "docker push registry.k8.wildwidewest.xyz/repository/docker-repository/pocs/books-api-simple:$now"

                }
            }

        container('kubectl') {


                build job: "books-api-simple-run/master",
                                  wait: false,
                                  parameters: [[$class: 'StringParameterValue', name: 'image', value: "$now"]]

        }
    }
}

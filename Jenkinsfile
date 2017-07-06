#!groovy
import java.text.SimpleDateFormat

podTemplate(label: 'helloworld-build-pod', nodeSelector: 'medium', containers: [
        containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:alpine'),
        containerTemplate(name: 'maven',
                image: 'maven:3.5.0',
                ttyEnabled: true,
                command: 'cat'),
        containerTemplate(name: 'docker',
                image: 'docker', command: 'cat', ttyEnabled: true), //
        containerTemplate(name: 'kubectl',
                image: 'lachlanevenson/k8s-kubectl', command: 'cat', ttyEnabled: true)
],
        volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]
) {

    node('helloworld-build-pod') {

        git credentialsId: '53c71862-c245-4f4a-8fa1-b86ef32d0092', url: 'https://git.wildwidewest.xyz/melkouhen/helloworld.git'

        container('maven') {

            sh 'mvn clean install'
        }

        container('docker') {

            sh 'mkdir /etc/docker'

            sh 'echo {"insecure-registries" : ["registry.wildwidewest.xyz"]} > /etc/docker/daemon.json'

            sh 'docker login -u admin -p admin123 registry.wildwidewest.xyz'

            sh 'docker build . -t registry.wildwidewest.xyz/repository/docker-repository/pocs/helloworld'

            sh 'docker push registry.wildwidewest.xyz/repository/docker-repository/pocs/helloworld'
        }

        container('kubectl') {

            sh 'kubectl --namespace=helloworld --server=http://92.222.81.117:8080 apply -f src/main/kubernetes/postgresql.yml'
            sh 'kubectl --namespace=helloworld --server=http://92.222.81.117:8080 apply -f src/main/kubernetes/helloworld.yml'
        }
    }
}

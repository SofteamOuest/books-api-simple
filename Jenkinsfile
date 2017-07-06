#!groovy
import java.text.SimpleDateFormat

podTemplate(label: 'mypod', nodeSelector: 'medium', containers: [
        containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:alpine'),
        containerTemplate(name: 'maven',
                image: 'maven:3.5.0',
                ttyEnabled: true,
                command: 'cat'),
        containerTemplate(name: 'docker',
                image: 'docker',
                ttyEnabled: true,
                command: 'cat')
]) {

    node('mypod') {

        git credentialsId: '53c71862-c245-4f4a-8fa1-b86ef32d0092', url: 'https://git.wildwidewest.xyz/melkouhen/helloworld.git'

        container('maven') {

            sh 'mvn clean install'

            sh 'curl -v -F r=snapshots -F hasPom=false -F e=jar ' +
                    '-F g=com.softeam.pocs -F a=helloworld -F v=1.0.0-SNAPSHOT -F p=jar ' +
                    '-F file=@helloworld.jar ' +
                    '-u admin:admin123 http://nexus.wildwidewest.xyz/service/local/artifact/maven/content'
        }
    }
}

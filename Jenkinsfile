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

            //sh 'mvn clean install'
        }

        container('docker') {

            sh 'ls -la /etc'

            sh 'mkdir /etc/docker'

            sh 'echo "{\"insecure-registries\" : [\"registry.wildwidewest.xyz\"]}" > /etc/docker/daemon.json'

            sh 'apk update'

            sh 'apk add openrc --no-cache'

            sh 'apk add docker'

            sh 'docker login -u admin -p admin123 registry.wildwidewest.xyz '
        }
    }
}

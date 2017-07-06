#!groovy
import java.text.SimpleDateFormat

podTemplate(label: 'mypod', nodeSelector: 'medium', containers: [
        containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:alpine'),
        containerTemplate(name: 'maven',
                image: 'maven:3.5.0',
                ttyEnabled: true,
                command: 'cat'),
        containerTemplate(name: 'docker', 
			image: 'docker', command: 'cat', ttyEnabled: true)], 
			volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]
		) {

    node('mypod') {

        git credentialsId: '53c71862-c245-4f4a-8fa1-b86ef32d0092', url: 'https://git.wildwidewest.xyz/melkouhen/helloworld.git'

        container('maven') {

            sh 'mvn clean install'
        }
    }
}

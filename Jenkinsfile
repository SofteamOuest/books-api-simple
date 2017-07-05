#!groovy
import java.text.SimpleDateFormat

/*
node {

    stage('checkout'){
        checkout scm
    }

    stage('build'){

        withMaven(maven: 'mvn 3.5.0') {
            sh "mvn -B clean install "
        }
    }
}*/


podTemplate(label: 'mypod', containers: [
        containerTemplate(name: 'maven',
                image: 'maven:3.3.9-jdk-8-alpine',
                ttyEnabled: true,
                command: 'cat')
]) {

    node('mypod') {

        /*git credentialsId: '53c71862-c245-4f4a-8fa1-b86ef32d0092', url: 'https://git.wildwidewest.xyz/melkouhen/helloworld.git'
*/
        container('maven') {

            sh 'pwd'
        }
    }
}

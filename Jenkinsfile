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
                image: 'maven:3.5-jdk-8',
                ttyEnabled: true,
                envVars: [
                        containerEnvVar(key: 'JENKINS_URL', value: 'jenkins')
                ])
]) {

    node('mypod') {
        stage('Get a Maven project') {
            git 'https://git.wildwidewest.xyz/melkouhen/helloworld.git'
            container('maven') {
                stage('Build a Maven project') {
                    sh 'mvn -B clean install'
                }
            }
        }
    }
}

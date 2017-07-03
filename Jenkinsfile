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

podTemplate(label: 'app: jenkins', containers: [
        containerTemplate(name: 'maven', image: 'maven:3.3.9-jdk-8-alpine', ttyEnabled: true, command: 'cat')
]) {

    node('app: jenkins') {
        stage('Get a Maven project') {
            git 'https://github.com/jenkinsci/kubernetes-plugin.git'
            container('maven') {
                stage('Build a Maven project') {
                    sh 'mvn -B clean install'
                }
            }
        }
    }
}
#!groovy
import java.text.SimpleDateFormat

node {

    stage('checkout'){
        checkout scm
    }

    stage('build'){
        withMaven( maven: 'mvn3') {
            sh "mvn -B clean compile "
        }
    }
}
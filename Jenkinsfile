#!groovy
import java.text.SimpleDateFormat

node {

    stage('checkout'){
        checkout scm
    }

    stage('build'){
        withMaven( maven: 'mvn 3.0.5') {
            sh "mvn -B clean compile "
        }
    }
}
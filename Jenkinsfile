#!groovy
import java.text.SimpleDateFormat

node {

    stage('checkout'){
        checkout scm
    }

    stage('build'){

        withMaven(maven: 'mvn 3.5.0') {
            sh "mvn -B clean install "
        }
    }
}
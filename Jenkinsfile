pipeline {
    agent any

    stages {


        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_3_9') {
                    sh 'mvn package'
                }
            }
        }

    }
}
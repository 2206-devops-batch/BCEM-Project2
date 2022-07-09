pipeline {
    agent any
    stages {
        stage("verify tooling") {
            steps {
                sh '''
                    echo "****************************************************************88"
                '''
            }
        }
    }
}
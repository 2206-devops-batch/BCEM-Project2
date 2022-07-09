pipeline {
    agent any
    environment {
        CREDS = credentials('bryon_user_password')
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                checkout([$class: 'GitSCM', branches: [[name: '*/bryon']],
    userRemoteConfigs: [[url: 'https://github.com/2206-devops-batch/BCEM-Project2.git']]])

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh '. $WORKSPACE/temp.sh'
                sh 'curl -u CREDS https://example.com'

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }
    }
}

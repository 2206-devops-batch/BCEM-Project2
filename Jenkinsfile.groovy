pipeline {
    agent none
    environment {
        CREDS = credentials('bryon_user_password')
    }
    stages {
        stage('Get Git') {
            agent {
                label 'agent1'
            }
            steps {
                // Get some code from a GitHub repository
                sh 'whoami'
                sh 'apt update && apt install git'
                sh 'git version'
    //             checkout([$class: 'GitSCM', branches: [[name: '*/bryon']],
    // userRemoteConfigs: [[url: 'https://github.com/2206-devops-batch/BCEM-Project2.git']]])

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"
                // sh '. $WORKSPACE/temp.sh'
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }
        stage('run shell') {
            agent {
                label 'agent2'
            }
            steps {
    //             // Get some code from a GitHub repository
    //             checkout([$class: 'GitSCM', branches: [[name: '*/bryon']],
    // userRemoteConfigs: [[url: 'https://github.com/2206-devops-batch/BCEM-Project2.git']]])

                // Run Maven on a Unix agent.
                // sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh 'whoami'
                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            
        }
    }
}

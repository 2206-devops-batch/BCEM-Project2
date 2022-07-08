pipeline {
    agent {label "Jenkies"}
    stages {
        stage('Test') {
            agent { label 'linuxdemo' }
            steps {
                sh 'pwd'
                sh 'ls'
                sh 'sudo apt install python3 -y'
                sh 'sudo apt install docker.io -y'
                sh 'sudo apt install python3-pip -y'
                sh 'pip3 install -r requirements.txt'
                sh 'python3 -m pytest app-test.py'
                // sh 'sudo docker login -u ${DOCK_USER} --password-stdin ${DOCK_PASSWORD}'
                sh 'sudo docker build /home/ubuntu/workspace/demo-cicd -t chamoo334/p2'
                sh 'sudo docker push chamoo334/p2'
            }
        }
        stage('Build and run') {
            agent { label 'linuxdemo' }
            steps {
                    sh 'sudo docker pull chamoo334/p2:latest'
                    sh 'sudo docker run chamoo334/p2 --name p2_app'
            }
        }
    }
}
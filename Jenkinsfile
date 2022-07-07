pipeline {
    agent any
    stages {
        stage{"test"} {

            steps {
                
                sh 'sudo yum install python3 -y'
                sh 'sudo yum install docker -y'
                sh 'sudo yum install pip -y'
                sh 'python3 -m venv .venv'
                sh 'pip3 install -r requirements.txt'
                sh 'python3 -m pytest app-test.py'
                sh 'sudo service docker start'
                sh 'sudo docker login -u $DOCKER_USER -p $DOCKER_PASSWORD'
                sh 'sudo docker build /home/ec2-user/workspace/Monikai -t chamoo334/p2'
                sh 'sudo docker push chamoo334/p2'
            }
        }
        stage("build and run") {
            steps {
                
                // login to dep server
                sshagent(credentials : ['dep-server']) {
                    sh 'whoami'
                    sh 'echo "*********************************************************************"'
                    sh 'sudo docker login -u ${env.DOCK_USER} -p ${env.DOCK_PASS}'
                    sh 'sudo docker pull chamoo334/p2:latest'
                    sh 'sudo docker run chamoo334/p2 --name p2_app'
                }

            }
        }
    }
}
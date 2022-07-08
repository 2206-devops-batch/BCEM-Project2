pipeline {
    agent {label "linuxdemo"}
    stages {
        stage{"test"} {
            agent { label 'linuxdemo' }
            steps {
                sh 'pwd'
                sh 'ls'
                sh 'sudo apt install python3 -y'
                sh 'sudo apt install docker.io -y'
                sh 'sudo apt install python3-pip -y'
                sh 'pip3 install -r requirements.txt'
                sh 'python3 -m pytest app-test.py'
                sh 'sudo docker login -u $DOCKER_USER -p $DOCKER_PASSWORD'
                sh 'sudo docker build /home/ec2-user/workspace/Monikai -t chamoo334/p2'
                sh 'sudo docker push chamoo334/p2'
            }
        }
        stage("build and run") {
            agent { label 'linuxdemo' }
            steps {

                    sh 'sudo docker login -u ${env.DOCK_USER} -p ${env.DOCK_PASS}'
                    sh 'sudo docker pull chamoo334/p2:latest'
                    sh 'sudo docker run chamoo334/p2 --name p2_app'
            }
        }
    }
}
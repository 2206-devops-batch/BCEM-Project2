<<<<<<< HEAD
# MonikaiT-project1
CI Pipeline for web app.
export FLASK_APP=app.py
export FLASK_ENV=development
flask run
http://127.0.0.1:5000
python web app built on flask using html script
=======
# MonikaiT-project1<br>
CICD Pipeline for web app.<br>

![CICD Pipeline](https://github.com/2206-devops-batch/BCEM-Project2/blob/master/proj2-initial-cicd.png)

# Continuous Integration
GitHub webhook notifies Jenkins of a push to master.<br>
Jenkins then spins up an EC2 instance for testing and building.<br>
If unittests pass, dcoker image is pushed to Docker Hub.

# Continuous Deployment
After successful push to Docker Hub, Jenkins uses ssh to pull and run the latest image from Docker Hub.


# Setup & Run: 
export FLASK_APP=app.py<br>
export FLASK_ENV=development<br>
flask run<br>
http://127.0.0.1:5000<br>
python web app built on flask using html script<br>
>>>>>>> eb61e96c06a636802df4f7fc23829c92d743c190
Hosted on get hub repository where commits are sent to jenkins.
 and forwarded to a docker image.<br>
 docker build -t monikait-project1
 
 #Hi...

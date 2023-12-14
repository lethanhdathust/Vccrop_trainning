FROM python:3.9-alpine
COPY requirements.txt requirements.txt
# RUN apt-get install python3-flask
RUN pip3 install -r requirements.txt
COPY app.py .
CMD [ "python3","app.py" ]
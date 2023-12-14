from flask import Flask
app = Flask(__name__)

@app.route('/')
def hello():
    return 'Hello, world! This is a Flask app.'
@app.route('/dat', methods=['GET'])
def ping():
    return 'pong'
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8080,debug=True)      

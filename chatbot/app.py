from flask import Flask, request, jsonify
from pymongo import MongoClient
from flask_cors import CORS

app = Flask(__name__)
CORS(app, resources={r"/chatbot/*": {"origins": "http://localhost:4200"}})  # Allow only this origin for /chatbot routes

# Connect to MongoDB using your connection URI
client = MongoClient("mongodb+srv://jihed:manajero@cluster0.nuhd6.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")
db = client["chatbot"]  # Replace "your_database" with the actual database name
responses_collection = db["responses"]

# Function to get response based on keyword
def get_bot_response(user_message):
    # Convert the user message to lowercase for case-insensitive matching
    user_message = user_message.lower()

    # Query MongoDB for any document where the keyword is in the user's message
    result = responses_collection.find_one({"keyword": {"$in": user_message.split()}})

    # If a response was found, return it
    if result:
        return result["response"]

    # Default response if no keyword matched
    return "I'm here to help with any medical questions you have."

# API endpoint for chatbot interaction
@app.route('/chatbot/ask', methods=['POST'])
def ask_bot():
    data = request.json
    user_message = data.get("message")
    bot_response = get_bot_response(user_message)

    return jsonify({"response": bot_response})

if __name__ == '__main__':
    # Bind to 0.0.0.0 to make the service accessible externally
    app.run(host='0.0.0.0', port=5000)

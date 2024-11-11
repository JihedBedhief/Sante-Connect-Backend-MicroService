# Dockerfile for Flask Chatbot
FROM python:3.9

WORKDIR /app

COPY . .

RUN pip install -r requirements.txt  # Ensure you have a requirements.txt

EXPOSE 5000

CMD ["python", "app.py"]  # Use your Flask script's name here

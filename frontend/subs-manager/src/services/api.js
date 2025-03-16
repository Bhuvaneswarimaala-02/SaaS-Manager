import axios from 'axios';

// Set backend base URL
const API_BASE_URL = 'http://localhost:8080/api';  // Change this if needed

// Create Axios instance
const api = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

// Function to register a new user
export const signup = async (userData) => {
    return api.post('/auth/signup', userData);
};

// Function to log in
export const login = async (credentials) => {
    return api.post('/auth/login', credentials);
};

// Fetch subscriptions
export const fetchSubscriptions = async () => {
    return api.get('/subscriptions');
};

// Add new subscription
export const addSubscription = async (data) => {
    return api.post('/subscriptions', data);
};

export default api;

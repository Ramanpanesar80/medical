// src/firebase.js
import { initializeApp } from 'firebase/app';
import { getFirestore } from 'firebase/firestore';
import { getAuth } from 'firebase/auth';

// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyDnzwBptCOQX59mGKHrbJuuW-KkyVlvZJA",
    authDomain: "medical-8afa0.firebaseapp.com",
    projectId: "medical-8afa0",
    storageBucket: "medical-8afa0.appspot.com",
    messagingSenderId: "1069806494436",
    appId: "1:1069806494436:web:2d0782659207260d9c42f1",
    measurementId: "G-0P32BJSKG0"
  };

// Initialize Firebase
const app = initializeApp(firebaseConfig);

// Initialize Firestore and Auth
const db = getFirestore(app);
const auth = getAuth(app);

export { db, auth };

package com.example.splash.cords;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseCords {
    public static final FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    public static final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public static final CollectionReference MAIN_CHAT_DATABASE = firebase.collection("CHAT");
    public static final CollectionReference MAIN_CHAT_DATABASE2 = firebase.collection("CHAT2");
    public static final CollectionReference MAIN_CHAT_DATABASE3 = firebase.collection("CHAT3");
}

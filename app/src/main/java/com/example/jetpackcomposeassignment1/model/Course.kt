package com.example.jetpackcomposeassignment1.model

/**
 * Data class representing an academic course.
 */
data class Course(
    val title: String,
    val code: String,
    val creditHours: Int,
    val description: String,
    val prerequisites: String
) 
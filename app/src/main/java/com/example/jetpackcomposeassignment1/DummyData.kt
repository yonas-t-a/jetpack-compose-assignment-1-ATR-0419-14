package com.example.jetpackcomposeassignment1

import com.example.jetpackcomposeassignment1.model.Course

object DummyData {
    val courses = listOf(
        Course(
            title = "Introduction to Computer Science",
            code = "CS101",
            creditHours = 3,
            description = "An introduction to the fundamental concepts of computer science, including algorithms, programming, and problem-solving techniques.",
            prerequisites = "None"
        ),
        Course(
            title = "Data Structures",
            code = "CS201",
            creditHours = 4,
            description = "Covers the implementation and application of data structures such as lists, stacks, queues, trees, and graphs.",
            prerequisites = "CS101"
        ),
        Course(
            title = "Operating Systems",
            code = "CS301",
            creditHours = 3,
            description = "Explores the design and implementation of modern operating systems, including process management, memory management, and file systems.",
            prerequisites = "CS201"
        ),
        Course(
            title = "Database Systems",
            code = "CS305",
            creditHours = 3,
            description = "Introduction to database concepts, relational models, SQL, and database design.",
            prerequisites = "CS201"
        ),
        Course(
            title = "Software Engineering",
            code = "CS310",
            creditHours = 3,
            description = "Principles and practices of software engineering, including requirements, design, testing, and maintenance.",
            prerequisites = "CS201"
        ),
        Course(
            title = "Artificial Intelligence",
            code = "CS401",
            creditHours = 3,
            description = "Introduction to AI concepts, search algorithms, knowledge representation, and machine learning basics.",
            prerequisites = "CS301, CS305"
        )
    )
}
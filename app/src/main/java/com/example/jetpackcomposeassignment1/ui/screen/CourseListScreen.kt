package com.example.jetpackcomposeassignment1.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeassignment1.data.DummyData
import com.example.jetpackcomposeassignment1.model.Course
import com.example.jetpackcomposeassignment1.ui.components.CourseCard
import com.example.jetpackcomposeassignment1.ui.theme.JetpackComposeAssignment1Theme

@Composable
fun CourseListScreen(
    courses: List<Course>,
    modifier: Modifier = Modifier
) {
    // Expansion state for each course, keyed by course code
    val expandedStates = rememberSaveable(
        courses,
        saver = mapSaver(
            save = { it.toMap() },
            restore = { restoredMap -> mutableStateMapOf<String, Boolean>().apply { putAll(
                restoredMap as Map<out String, Boolean>
            ) } }
        )
    ) {
        mutableStateMapOf<String, Boolean>().apply {
            courses.forEach { put(it.code, false) }
        }
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Course List",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 32.dp, bottom = 16.dp)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(courses, key = { it.code }) { course ->
                    CourseCard(
                        course = course,
                        isexpanded = expandedStates[course.code] == true,
                        onCardClick = {
                            expandedStates[course.code] = !(expandedStates[course.code] ?: false)
                        }
                    )
                }
            }
        }
    }
}

@Preview(name = "CourseListScreen Light", showBackground = true)
@Composable
fun PreviewCourseListScreenLight() {
    JetpackComposeAssignment1Theme(darkTheme = false) {
        CourseListScreen(courses = DummyData.courses)
    }
}

@Preview(name = "CourseListScreen Dark", showBackground = true)
@Composable
fun PreviewCourseListScreenDark() {
    JetpackComposeAssignment1Theme(darkTheme = true) {
        CourseListScreen(courses = DummyData.courses)
    }
} 
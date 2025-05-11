package com.example.jetpackcomposeassignment1.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeassignment1.model.Course
import com.example.jetpackcomposeassignment1.ui.theme.JetpackComposeAssignment1Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseCard(
    course: Course,
    isexpanded: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(shape)
            .clickable { onCardClick() }
            .animateContentSize(),
        tonalElevation = 2.dp,
        shape = shape,
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(top = 4.dp, bottom = 2.dp)
                    ) {
                        Surface(
                            shape = MaterialTheme.shapes.small,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            tonalElevation = 1.dp
                        ) {
                            Text(
                                text = course.code,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                            )
                        }
                        Spacer(
                            modifier = Modifier.width(8.dp),
                        )
                        Text(
                            text = course.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Credit Hours: ${course.creditHours}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(onClick = onCardClick) {
                    Icon(
                        imageVector = if (isexpanded) {
                            Icons.Filled.ExpandLess
                        } else {
                            Icons.Filled.ExpandMore
                               },
                        contentDescription = if (isexpanded) "Collapse" else "Expand"
                    )
                }
            }
            if (isexpanded) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = course.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Prerequisites: ${course.prerequisites}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Preview(name = "CourseCard Light", showBackground = true)
@Composable
fun PreviewCourseCardLight() {
    JetpackComposeAssignment1Theme(darkTheme = false) {
        var expanded by remember { mutableStateOf(false) }
        CourseCard(
            course = Course(
                title = "Sample Course",
                code = "CS999",
                creditHours = 3,
                description = "This is a sample course description.",
                prerequisites = "None"
            ),
            isexpanded = expanded,
            onCardClick = { expanded = !expanded }
        )
    }
}

@Preview(name = "CourseCard Dark", showBackground = true)
@Composable
fun PreviewCourseCardDark() {
    JetpackComposeAssignment1Theme(darkTheme = true) {
        var expanded by remember { mutableStateOf(true) }
        CourseCard(
            course = Course(
                title = "Sample Course",
                code = "CS999",
                creditHours = 3,
                description = "This is a sample course description.",
                prerequisites = "None"
            ),
            isexpanded = expanded,
            onCardClick = { expanded = !expanded }
        )
    }
} 
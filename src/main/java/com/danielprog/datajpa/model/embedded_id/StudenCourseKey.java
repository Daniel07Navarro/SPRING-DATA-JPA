package com.danielprog.datajpa.model.embedded_id;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StudenCourseKey implements Serializable {

    //columnas que seran las llaves compuestas de la relacion
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudenCourseKey that = (StudenCourseKey) o;
        return studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }

    @Override
    public String toString() {
        return "StudenCourseKey{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}

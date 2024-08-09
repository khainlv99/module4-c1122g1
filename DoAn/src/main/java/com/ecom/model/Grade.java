package com.ecom.model;

import jakarta.persistence.*;

    @Entity
    public class Grade {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Double grade;

        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;

        @ManyToOne
        @JoinColumn(name = "subject_id")
        private Subject subject;

        public Grade() {
        }

        public Grade(Long id, Double grade, Student student, Subject subject) {
            this.id = id;
            this.grade = grade;
            this.student = student;
            this.subject = subject;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Double getGrade() {
            return grade;
        }

        public void setGrade(Double grade) {
            this.grade = grade;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Subject getSubject() {
            return subject;
        }

        public void setSubject(Subject subject) {
            this.subject = subject;
        }

        @Override
        public String toString() {
            return "Grade{" +
                    "id=" + id +
                    ", grade=" + grade +
                    ", student=" + student +
                    ", subject=" + subject +
                    '}';
        }
}

import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container } from "@mui/system";
import { Paper } from "@mui/material";
import { useState, useEffect } from "react";
import Button from "@mui/material/Button";

export default function Student() {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");

  const [students, setStudents] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const student = { name, address };
    console.log(student);

    fetch("http://localhost:8080/student/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(student),
    }).then(() => console.log("New Student Added"));
  };

  const paperStyle = {
    padding: "50px 20px",
    width: 600,
    margin: "20px auto",
  };

  useEffect(() => {
    fetch("http://localhost:8080/student/getAll")
      .then((res) => res.json())
      .then((result) => {
        setStudents(result);
      });
  }, []);

  return (
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{ color: "blue" }}>Add Student</h1>
        <Box
          component="form"
          sx={{
            "& > :not(style)": { mb: 2 },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="outlined-basic"
            label="Student Name"
            variant="outlined"
            fullWidth
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Student Address"
            variant="outlined"
            fullWidth
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
          <Button variant="contained" onClick={handleClick}>
            Submit
          </Button>
        </Box>
      </Paper>
      <h1>Students</h1>
      {students.id}
      {students.name}
      {students.address}
      <Paper elevation={3} style={paperStyle}>
        {students.map((student) => (
          <Paper
            elevation={6}
            style={{ margin: "10px", padding: "16px", textAlign: "left" }}
            key={student.id}
          >
            Id: {student.id}
            <br />
            Name: {student.name}
            <br />
            Address: {student.address}
          </Paper>
        ))}
      </Paper>
    </Container>
  );
}

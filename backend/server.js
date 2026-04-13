const express = require("express");
const cors = require("cors");
const db = require("./db");

const app = express();
app.use(cors());
app.use(express.json());

app.post("/add-subject", (req, res) => {
  const { name, hours } = req.body;

  db.query(
    "INSERT INTO subjects (name, hours) VALUES (?, ?)",
    [name, hours],
    (err) => {
      if (err) return res.send(err);
      res.send("Added");
    }
  );
});

app.get("/subjects", (req, res) => {
  db.query("SELECT * FROM subjects", (err, result) => {
    if (err) return res.send(err);
    res.json(result);
  });
});

app.listen(5000, () => {
  console.log("🚀 Server running on port 5000");
});
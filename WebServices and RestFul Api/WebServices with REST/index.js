const express = require('express');
const cors = require('cors');
const app = express();
const PORT = 3000;

// Middleware to enable CORS and parse JSON requests
//Cross-Origin Resource Sharing.
app.use(cors());
app.use(express.json());

// Sample Data
let users = [
  { id: 1, name: "Vijay Kumar" },
  { id: 2, name: "Priya Jhosi" }
];

// GET /users - Retrieve all users
app.get('/users', (req, res) => {
  res.json(users);
});

// GET /users/:id - Retrieve a user by ID
app.get('/users/:id', (req, res) => {
  const user = users.find(u => u.id === parseInt(req.params.id));
  if (!user) return res.status(404).send("User not found");
  res.json(user);
});

// POST /users - Create a new user
app.post('/users', (req, res) => {
  const newUser = {
    id: users.length + 1,
    name: req.body.name
  };
  users.push(newUser);
  res.status(201).json(newUser);
});

// PUT /users/:id - Update a user's name
app.put('/users/:id', (req, res) => {
  const user = users.find(u => u.id === parseInt(req.params.id));
  if (!user) return res.status(404).send("User not found");
  user.name = req.body.name;
  res.json(user);
});

// DELETE /users/:id - Delete a user
app.delete('/users/:id', (req, res) => {
  users = users.filter(u => u.id !== parseInt(req.params.id));
  res.send("User deleted");
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});

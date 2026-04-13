const API = "http://localhost:5000";

/* ---------- LOAD SUBJECTS ---------- */
async function loadSubjects() {
  try {
    let res = await fetch(API + "/subjects");
    let data = await res.json();

    let list = document.getElementById("list");
    list.innerHTML = "";

    data.forEach(s => {
      let li = document.createElement("li");

      li.innerHTML = `
        ${s.name} - ${s.hours} hrs 
        <button onclick="deleteSubject(${s.id})">❌</button>
      `;

      list.appendChild(li);
    });

  } catch (err) {
    console.error("Error loading subjects:", err);
  }
}

/* ---------- ADD SUBJECT ---------- */
async function addSubject() {
  let name = document.getElementById("name").value.trim();
  let hours = document.getElementById("hours").value.trim();

  // ✅ Validation
  if (!name || !hours) {
    alert("Please enter subject and hours");
    return;
  }

  try {
    await fetch(API + "/add-subject", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ name, hours })
    });

    // ✅ Clear input fields
    document.getElementById("name").value = "";
    document.getElementById("hours").value = "";

    loadSubjects();

  } catch (err) {
    console.error("Error adding subject:", err);
  }
}

/* ---------- DELETE SUBJECT ---------- */
async function deleteSubject(id) {
  try {
    await fetch(`${API}/delete/${id}`, {
      method: "DELETE"
    });

    loadSubjects();

  } catch (err) {
    console.error("Error deleting subject:", err);
  }
}

/* ---------- INITIAL LOAD ---------- */
loadSubjects();
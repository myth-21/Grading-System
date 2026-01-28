<!DOCTYPE html>
<html>
<head>
    <title>Grade Result</title>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: "Segoe UI", Arial;
            background: linear-gradient(120deg, #f6d365, #fda085);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .result-card {
            background: white;
            padding: 30px;
            width: 400px;
            border-radius: 12px;
            box-shadow: 0px 10px 25px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .row {
            margin: 10px 0;
            font-size: 16px;
        }

        .label {
            font-weight: bold;
            color: #555;
        }

        .grade {
            font-size: 20px;
            font-weight: bold;
            color: #2e7d32;
        }

        .btn {
            margin-top: 20px;
            text-align: center;
        }

        a {
            text-decoration: none;
            padding: 10px 20px;
            background: #ff7a18;
            color: white;
            border-radius: 6px;
            transition: 0.3s;
        }

        a:hover {
            background: #e86b10;
        }
    </style>
</head>

<body>

<div class="result-card">
    <h2>Grade Report</h2>

    <div class="row"><span class="label">Student Name:</span> ${name}</div>
    <div class="row"><span class="label">Roll Number:</span> ${roll}</div>
    <div class="row"><span class="label">Subject:</span> ${subject}</div>
    <div class="row"><span class="label">Marks:</span> ${marks}</div>
    <div class="row grade">Grade: ${grade}</div>

    <div class="btn">
        <a href="index.html">Enter Another Student</a>
    </div>
</div>

</body>
</html>

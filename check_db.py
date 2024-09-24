import os
import sqlite3

db_filename = 'MovieApp.db'
db_path = os.path.join(os.getcwd(), db_filename)

if os.path.exists(db_path):
    print("File exists.")
    try:
        conn = sqlite3.connect(db_path)
        cursor = conn.cursor()
        cursor.execute("SELECT name FROM sqlite_master WHERE type='table';")
        tables = cursor.fetchall()
        print("Tables in DB:", tables)

        table_structures = {}
        for table in tables:
            table_name = table[0]
            cursor.execute(f"PRAGMA table_info({table_name});")
            table_structures[table_name] = cursor.fetchall()

        conn.close()
        print("Table structure:", table_structures)
    except sqlite3.Error as e:
        print("Error:", str(e))
else:
    print("File does not exist.")

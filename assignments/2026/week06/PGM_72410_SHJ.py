import re

def solution(new_id):
    new_id = new_id.lower()
    new_id = re.sub(r'[^a-z0-9\-_.]', '', new_id)
    while ".." in new_id:
        new_id = new_id.replace("..", ".")
    new_id = new_id.strip(".")
    new_id = new_id or "a"
    new_id = new_id[:15].rstrip(".")
    if len(new_id) <= 2:
        while len(new_id) < 3:
            new_id += new_id[-1]
    return new_id

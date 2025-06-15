import subprocess

START_TAG = "<!-- SOLVE_STATS_START -->"
END_TAG = "<!-- SOLVE_STATS_END -->"
README_FILE = "README.md"

# 1. Bash 스크립트를 실행해서 표 데이터 가져오기
print("▶️ Generating solve stats from git log...")
output = subprocess.check_output(["bash", "scripts/generate_stats.sh"]).decode().strip()
print(output)

# 2. README.md 불러오기
with open(README_FILE, "r", encoding="utf-8") as f:
    content = f.read()

# 3. 삽입 구간 교체
before = content.split(START_TAG)[0]
after = content.split(END_TAG)[-1]
new_block = f"{START_TAG}\n{output}\n{END_TAG}"
new_content = before + new_block + after

# 4. README.md 갱신
with open(README_FILE, "w", encoding="utf-8") as f:
    f.write(new_content)

print("✅ README.md successfully updated.")

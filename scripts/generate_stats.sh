#!/bin/bash

echo "| 이름 | Solve 커밋 수 |"
echo "|------|----------------|"
git log main --grep="solve" --pretty='%an' | sort | uniq -c | sort -nr | while read count name; do
    echo "| $name | $count |"
done

class Solution {
    public String solution(String new_id) {
        StringBuilder tmp = new StringBuilder();

        for (char c : new_id.toCharArray()) {
            if ('A' <= c && c <= 'Z') c = (char) (c + 32);

            if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z') ||
                    c == '-' || c == '_' || c == '.') {

                if (c == '.' && (tmp.length() == 0 || tmp.charAt(tmp.length() - 1) == '.'))
                    continue;

                tmp.append(c);
            }
        }

        String id = tmp.toString();
        id = id.replaceAll("^\\.+|\\.+$", "");

        if (id.isEmpty()) id = "aaa";

        if (id.length() > 15)
            id = id.substring(0, 15).replaceAll("\\.+$", "");

        while (id.length() < 3)
            id += id.charAt(id.length() - 1);

        return id;
    }
}

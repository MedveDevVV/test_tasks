import java.security.SecureRandom;

public class PasswordGenerator {
    private PasswordLength pwdLength;
    private final String symbolSet;

    enum PasswordLength {
        _8(8),
        _9(9),
        _10(10),
        _11(11),
        _12(12);
        private final int length;
        PasswordLength(int length) {
            this.length = length;
        }

        public int getLength() {
            return length;
        }
    }

    public PasswordGenerator() {
        StringBuilder symbolSet = new StringBuilder();
        for (int i = 33; i < 127; ++i) { // 33 - 126 диапазон ASCII символов для пароля
            if (i != '\'' && i != '\"' && i != '\\' && i != '`' && i != '|' && i != '<' && i != '>')
                symbolSet.append((char) i);
        }
        this.symbolSet = String.valueOf(symbolSet);
        pwdLength = PasswordLength._12;
    }

    public void setLength(PasswordLength length) {
        if (length == null) return;
        pwdLength = length;
    }

    public int getLength() {
        return pwdLength.getLength();
    }

    public String getPassword() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder password = new StringBuilder(pwdLength.getLength());
        for (int i = 0; i < pwdLength.getLength(); ++i) {
            password.append(symbolSet.charAt(secureRandom.nextInt(symbolSet.length())));
        }
        return password.toString();
    }

}


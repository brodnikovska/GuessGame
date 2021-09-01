public enum SystemMessages {

        HELLO_WORLD("Hello world!"),
        WRONG_GREETING("Ups, wrong greeting... Must be \"%s\", but was \"%s\""),
        INPUT_WORD("Please, enter your word: "),
        WRONG_WORD("Wrong word! Please, try again. ");

        private final String message;

        SystemMessages(String s) {
            message = s;
        }
        @Override
        public String toString() {
            return this.message;
        }
}

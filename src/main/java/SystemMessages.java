public enum SystemMessages {

        HELLO_WORLD("Hello world!"),
        WRONG_GREETING("Ups, wrong greeting... Must be \"%s\", but was \"%s\""),
        INPUT_WORD("Please, enter your word: "),
        INPUT_INT("Input INT value: "),
        WRONG_WORD("Wrong word! Please, try again. "),
        WRONG_INT("Wrong input. Int value is expected. "),
        PREVIOUS_ATTEMPTS("Your previous attempts: "),
        LAST_ATTEMPT("Last attempt: "),
        SELECTIVE_INT("Please, try again. Your value must be between %s and %s."),
        WIN_MESSAGE("You won. The number is: %s");

        private final String message;

        SystemMessages(String s) {
            message = s;
        }
        @Override
        public String toString() {
            return this.message;
        }
}

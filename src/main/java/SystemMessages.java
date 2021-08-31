public enum SystemMessages {

        HELLO_WORLD("Hello world!"),
        WRONG_GREETING("Ups, wrong greeting... Must be \"%s\", but was \"%s\"");

        private final String message;

        SystemMessages(String s) {
            message = s;
        }
        @Override
        public String toString() {
            return this.message;
        }
}

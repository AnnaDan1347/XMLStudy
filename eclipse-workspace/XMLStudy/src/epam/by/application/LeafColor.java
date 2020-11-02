package epam.by.application;

public class LeafColor extends AVisual{

        public LeafColor() {
            super("Цвет листьев");
        }

        private String leafColor;

        @Override
        public void setValue(String value) {
            this.leafColor = value;

        }

        @Override
        public String getValue() {
            return leafColor;
        }
    }




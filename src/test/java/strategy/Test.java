package strategy;
class TestSub {
    public static void main(String[] args) {
    }
}

class Test {
    public static void main(String[] args) {
        AbstractStrategyRouter router1 = new AbstractStrategyRouter<String,String>() {
            @Override
            protected StrategyMapper<String, String> registerStrategyMapper() {
                StrategyMapper<String, String> mapper = new StrategyMapper<String, String>() {
                    @Override
                    public StrategyHandler<String, String> get(String param) {
                        return new StrategyHandler<String, String>() {
                            @Override
                            public String apply(String param) {
                                return "1";
                            }
                        };
                    }
                };
                return mapper;
            }
        };
        AbstractStrategyRouter router2 = new AbstractStrategyRouter<String,String>() {
            @Override
            protected StrategyMapper<String, String> registerStrategyMapper() {
                StrategyMapper<String, String> mapper = new StrategyMapper<String, String>() {
                    @Override
                    public StrategyHandler<String, String> get(String param) {
                        return new StrategyHandler<String, String>() {
                            @Override
                            public String apply(String param) {
                                return "1";
                            }
                        };
                    }
                };
                return mapper;
            }
        };

        router1.applyStrategy("");
        router2.applyStrategy("");

        System.out.println("xx");


    }
}

package opt;

import java.util.ArrayList;
import java.util.List;

public class Lab2 {

    public static void main(String[] args) {
        // Исходные данные
        List<Double> x0 = List.of(0.5, 1.0);
        final double eps = 0.01;
        final double t0 = 0.5;

        Pair<List<Double>, Double> result = grad_descend(x0, eps, t0);

        System.out.println("Градиентный спуск с постоянным шагом: ");
        System.out.print("x* = {");
        for (int i = 0; i < result.getX_array().size(); i++) {
            System.out.print(result.getX_array().get(i));
            if (i != result.getX_array().size() - 1) {
                System.out.print("; ");
            }
        }
        System.out.println("}");
        System.out.println("f(x*) = " + result.getF());

        System.out.println("- - - - - - - - - - - - - - - - - -");

        result = fastest_grad_descend(x0, eps, t0);

        System.out.println("Наискорейший градиентный спуск: ");
        System.out.print("x* = {");
        for (int i = 0; i < result.getX_array().size(); i++) {
            System.out.print(result.getX_array().get(i));
            if (i != result.getX_array().size() - 1) {
                System.out.print("; ");
            }
        }
        System.out.println("}");
        System.out.println("f(x*) = " + result.getF());
    }

    static double f(List<Double> x) {
        double x1 = x.get(0);
        double x2 = x.get(1);
        return 2 * x1 * x1 + x1 * x2 + x2 * x2;
    }

    static List<Double> grad_f(List<Double> x) {
        double x1 = x.get(0);
        double x2 = x.get(1);
        double f_x1 = 4 * x1 + x2;
        double f_x2 = x1 + 2 * x2;
        return List.of(f_x1, f_x2);
    }

    static double norm(List<Double> grad_f) {
        double x1 = grad_f.get(0);
        double x2 = grad_f.get(1);
        return Math.sqrt(x1 * x1 + x2 * x2);
    }

    static Pair<List<Double>, Double> grad_descend(List<Double> x0, double eps, double t0) {
        int k = 0;
        List<Double> x_k = x0;
        List<Double> x_next;

        while (true) {
            List<Double> grad = grad_f(x_k);

            if (norm(grad) < eps) {
                System.out.println("итерация " + k);
                return new Pair<>(x_k, f(x_k));
            }
            double t_k = t0;

            while (true) {
                x_next = v_sum(x_k, mult((-1.0) * t_k, grad_f(x_k)));
                if (f(x_next) - f(x_k) >= 0) {
                    t_k = t_k / 2;
                } else {
                    break;
                }
            }

            if (norm(v_sum(x_next, mult(-1.0, x_k))) < eps &&
                    Math.abs(f(x_next) - f(x_k)) < eps)
            {
                System.out.println("итерация " + k);
                return new Pair<>(mult(0.1, x_next), f(x_next));
            } else {
                k++;
                System.out.println("xk -> " + x_k + " f(x_k) -> " + f(x_k));

                x_k = x_next;
            }
        }
    }

    static Pair<List<Double>, Double> fastest_grad_descend(List<Double> x0, double eps, double t0) {
        int k = 0;
        List<Double> x_k = x0;
        List<Double> x_next;
        double t_k = t0;

        while (true) {
            List<Double> grad = grad_f(x_k);
            if (norm(grad) < eps) {
                System.out.println("итерация " + k);
                return new Pair<>(x_k, f(x_k));
            }

            t_k = gold(-1, 1, eps, x_k);
            x_next = v_sum(x_k, mult((-1.0) * t_k, grad));

            if (norm(v_sum(x_next, mult(-1.0, x_k))) < eps &&
                    Math.abs(f(x_next) - f(x_k)) < eps)
            {
                System.out.println("итерация " + k);
                return new Pair<>(x_next, f(x_next));
            } else {
                k++;
                System.out.println("xk -> " + x_k + " f(x_k) -> " + f(x_k));
                x_k = x_next;
            }
        }
    }

    static List<Double> mult(double lambda, List<Double> v) {
        List<Double> result = new ArrayList<>();
        for (double value : v) {
            result.add(value * lambda);
        }
        return result;
    }

    static List<Double> v_sum(List<Double> v1, List<Double> v2) {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            result.add(v1.get(i) + v2.get(i));
        }
        return result;
    }

    static double phi(double t, List<Double> x_k) {
        return f(v_sum(x_k, mult(-1.0 * t, grad_f(x_k))));
    }

    static double gold(double a, double b, double eps, List<Double> x_k) {
        double tau = (Math.sqrt(5) + 1) / 2;

        while (Math.abs(b - a) >= eps) {
            double x1 = b - (b - a) / tau;
            double x2 = a + (b - a) / tau;
            double y1 = phi(x1, x_k);
            double y2 = phi(x2, x_k);

            if (y1 >= y2) {
                a = x1;
            } else {
                b = x2;
            }
        }
        return (a + b) / 2;
    }

    static class Pair<T, U> {
        private final T first;
        private final U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        public T getX_array() {
            return first;
        }

        public U getF() {
            return second;
        }
    }
}

package com.prodius.container;

import com.prodius.model.Car;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
public class CarTree<T extends Car> {
    private T car;
    private CarComparator<T> carComparator;
    private TreeNode<T> root;

    public CarTree(T car) {
        carComparator = new CarComparator<>();
        this.car = car;
    }
    public CarTree() {
        carComparator = new CarComparator<>();
        this.root = null;
    }
    public void insertNode(T car) {
        int position = 2;
        TreeNode<T> treeNode = new TreeNode<>(car, null, null);
        if (root == null) {
            root = treeNode;
        } else {
            TreeNode<T> current = root;
            while (true) {
                position = carComparator.compare(treeNode.getValue(), current.getValue());
                if (position == -1) {
                    if (current.getLeft() == null) {
                        current.setLeft(treeNode);
                        return;
                    }
                    current = current.getLeft();
                }else if(position == 1 || position == 0) {
                    if (current.getRight() == null) {
                        current.setRight(treeNode);
                        return;
                    }
                    current = current.getRight();
                }else{
                    return;
                }
            }
        }
    }
    public int getLeftCount() {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        TreeNode<T> current = root;
        int totalCount = 0;
        if (current == null) {
            return totalCount;
        }
        while (true) {
            while (current != null) {
                if (current.getRight() != null) {
                    if (current != root) {
                        queue.push(current.getRight());
                    }
                }
                totalCount += current.getValue().getCount();
                current = current.getLeft();
            }
            while (queue.size() > 0) {
                current = queue.pop();
                break;
            }
            if (queue.size() == 0 && current == null) {
                break;
            }
        }
        return totalCount;
    }
    public int getRightCount() {
        LinkedList<TreeNode<T>> queue = new LinkedList<>();
        TreeNode<T> current = root;
        int totalCount = 0;
        if (current == null) {
            return totalCount;
        }
        while (true) {
            while (current != null) {
                if (current.getLeft() != null) {
                    if (current != root) {
                        queue.push(current.getLeft());
                    }
                }
                totalCount += current.getValue().getCount();
                current = current.getRight();
            }
            while (queue.size() > 0) {
                current = queue.pop();
                break;
            }
            if (queue.size() == 0 && current == null) {
                break;
            }
        }
        return totalCount;
    }
    @Getter
    @Setter
    private class TreeNode<T> {
        private T value;
        private TreeNode<T> left;
        private TreeNode<T> right;

        TreeNode(T value, TreeNode<T>  left, TreeNode<T>  right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

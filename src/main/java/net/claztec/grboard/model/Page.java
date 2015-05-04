package net.claztec.grboard.model;

/**
 * Created by Derek Choi on 15. 5. 4.
 */
public class Page {

    // default offset = 0, limit = 20
    int totalItemCount = 0;
    int offset = 0;
    int limit = 20;

    public Page() {
    }

    public Page(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean hasNext() {
        if (offset / limit <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasPrevious() {
        if (totalItemCount < offset + limit) {
            return false;
        } else {
            return true;
        }
    }

    public int next() {
        if (offset - limit <= 0) {
            return 0;
        } else {
            return offset - limit;
        }
    }

    public int previous() {
        if (totalItemCount < offset + limit) {
            return offset;
        } else {
            return offset + limit;
        }
    }
}

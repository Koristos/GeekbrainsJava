package ru.daniilazarnov;

public interface PathHolder {

    void setAuthority(String path);

    String getAuthority();

    void setFileLength(long length);

    long getFileLength();

    void transComplete();

    void sendMessage(String message);

    public String getLogin();
}

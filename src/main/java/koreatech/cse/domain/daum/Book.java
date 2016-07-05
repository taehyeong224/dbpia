package koreatech.cse.domain.daum;

public class Book
{
    private Channel channel;

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [channel = "+channel+"]";
    }
}


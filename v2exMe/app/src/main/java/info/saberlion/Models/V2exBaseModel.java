package info.saberlion.Models;

import java.io.Serializable;

/**
 * Created by shirley on 15/10/20.
 */
public class V2exBaseModel implements Serializable {
    public String iid;
    public String title;
    public String url;
    public String content;
    public String content_rendered;
    public String replies;
    public String created;
    public String last_modified;
    public String last_touched;
    public V2exMemberModel memberModel;
    public V2exNodeModel nodeModel;
}

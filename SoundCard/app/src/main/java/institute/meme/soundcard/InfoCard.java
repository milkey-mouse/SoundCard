package institute.meme.soundcard;

public class InfoCard {
    public CardType card_type;
    public String title;
    public String text;
    public String url;
    public int icon;

    public InfoCard(CardType _card_type, String _text) {
        card_type = _card_type;
        switch (_card_type) {
            case TEXT:
                icon = R.drawable.text;
                title = "Text";
                text = _text;
                url = null;
                break;
            case LINK:
                icon = R.drawable.link;
                title = "Link";
                text = _text;
                url = _text;
                break;
            case EMAIL:
                icon = R.drawable.email;
                title = "Email";
                text = _text;
                url = "mailto:" + text;
                break;
            case GITHUB:
                icon = R.drawable.github;
                title = "GitHub";
                text = "github.com/" + _text;
                url = "https://github.com/" + _text;
                break;
            case REDDIT:
                icon = R.drawable.reddit;
                title = "Reddit";
                text = "/u/" + _text;
                url = "https://reddit.com/u/" + _text;
                break;
            case TUMBLR:
                icon = R.drawable.tumblr;
                title = "Tumblr";
                text = _text + ".tumblr.com";
                url = "https://" + _text + ".tumblr.com";
                break;
            case TWITTER:
                icon = R.drawable.twitter;
                title = "Twitter";
                text = "@" + _text;
                url = "https://twitter.com/" + _text;
                break;
            case SNAPCHAT:
                icon = R.drawable.snapchat;
                title = "Snapchat";
                text = "@" + _text;
                url = "https://www.snapchat.com/add/" + _text;
                break;
            case FACEBOOK:
                icon = R.drawable.facebook;
                title = "Facebook";
                text = _text;
                url = "https://www.facebook.com/" + _text;
                break;
            case INSTAGRAM:
                icon = R.drawable.instagram;
                title = "Instagram";
                text = "@" + _text;
                url = "https://www.instagram.com/" + _text;
                break;
            default:
                break;
        }
    }
}
